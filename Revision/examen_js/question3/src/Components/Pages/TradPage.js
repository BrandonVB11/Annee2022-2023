/* eslint-disable */

const TradPage = () => {
    const main = document.querySelector('main');
    main.innerHTML = `
    <form id="translationForm">
    <div class="mb-3">
    <label for="frenchWord" class="form-label">Mot en français</label>
    <input type="text" class="form-control" id="frenchWord" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
    <label for="englishTranslation" class="form-label">Traduction en anglais</label>
    <input type="text" class="form-control" id="englishTranslation">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    `;

    const translationForm = document.getElementById('translationForm');
    translationForm.addEventListener('submit', async (event) => {
        event.preventDefault();

        const frenchWordInput = document.getElementById('frenchWord');
        const englishTranslationInput = document.getElementById('englishTranslation');

        const frenchWord = frenchWordInput.value;
        const englishTranslation = englishTranslationInput.value;

        const translationData = {
            fr: frenchWord,
            en: englishTranslation
        };

        try {
            const response = await fetch('/traduction', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(translationData)
            });

            if (response.ok) {
                clearForm();
            } else {
                console.error('Erreur lors de la requête POST:', response.statusText);
            }
        } catch (error) {
            console.error('Erreur lors de la requête POST:', error);
        }
    });

    function clearForm() {
        document.getElementById('frenchWord').value = '';
        document.getElementById('englishTranslation').value = '';
    }
};

export default TradPage;
