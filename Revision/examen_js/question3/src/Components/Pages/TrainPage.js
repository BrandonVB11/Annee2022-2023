/* eslint-disable */

const TradPage = () => {
    const main = document.querySelector('main');
    main.innerHTML = `
    <div>
        <h2>Traduction du français à l'anglais</h2>
        <form id="frenchToEnglishForm">
            <div class="mb-3">
                <label for="frenchWord" class="form-label">Mot en français</label>
                <input type="text" class="form-control" id="frenchWord">
            </div>
            <div id="frenchToEnglishTranslation" class="translation-result"></div>
            <button type="submit" class="btn btn-primary">Traduire</button>
        </form>
    </div>
    <div>
        <h2>Traduction de l'anglais au français</h2>
        <form id="englishToFrenchForm">
            <div class="mb-3">
                <label for="englishWord" class="form-label">Mot en anglais</label>
                <input type="text" class="form-control" id="englishWord">
            </div>
            <div id="englishToFrenchTranslation" class="translation-result"></div>
            <button type="submit" class="btn btn-primary">Traduire</button>
        </form>
    </div>
    `;

    // frontend.js

const fetchTranslation = async (url) => {
    try {
        const response = await fetch(url);
        if (response.ok) {
            const data = await response.json();
            return data.translation || "Impossible d'obtenir la traduction";
        } else {
            throw new Error('Erreur lors de la requête GET');
        }
    } catch (error) {
        console.error('Erreur lors de la requête GET:', error);
        return "Impossible d'obtenir la traduction";
    }
};

const displayTranslationResult = (elementId, translation) => {
    const translationElement = document.getElementById(elementId);
    translationElement.textContent = translation;
    if (translation === "Impossible d'obtenir la traduction") {
        translationElement.style.color = 'red';
    } else {
        translationElement.style.color = 'black';
    }
};


const handleFrenchToEnglishTranslation = async (event) => {
    event.preventDefault();
    const frenchWord = document.getElementById('frenchWord').value;
    const translation = await fetchTranslation(`/trad/fr?query=${encodeURIComponent(frenchWord)}`);
    displayTranslationResult('frenchToEnglishTranslation', translation);
};

const handleEnglishToFrenchTranslation = async (event) => {
    event.preventDefault();
    const englishWord = document.getElementById('englishWord').value;
    const translation = await fetchTranslation(`/trad/en?query=${encodeURIComponent(englishWord)}`);
    displayTranslationResult('englishToFrenchTranslation', translation);
};

// ... Autres fonctions et logique pour l'affichage et la gestion des résultats

// Écouteurs d'événements pour les formulaires
const frenchToEnglishForm = document.getElementById('frenchToEnglishForm');
frenchToEnglishForm.addEventListener('submit', handleFrenchToEnglishTranslation);

const englishToFrenchForm = document.getElementById('englishToFrenchForm');
englishToFrenchForm.addEventListener('submit', handleEnglishToFrenchTranslation);
};

export default TradPage;
