/* eslint-disable */

import questions from "../../utils/questions";

const ramdomizeNumbers1 = Math.floor(Math.random() * questions.length);
const ramdomizeNumbers2 = Math.floor(Math.random() * questions.length);
const ramdomizeNumbers3 = Math.floor(Math.random() * questions.length);

const GamePage = () => {
    const main = document.querySelector('main');
    main.innerHTML = `
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1>Game Page</h1>
            </div>
            <div class="questions-container col-12">
                <!-- Question 1 -->
                <div class="question">
                    <h3>${questions[ramdomizeNumbers1].question}</h3>
                    <form id="question-0">
                        ${questions[ramdomizeNumbers1].answers.map((answer, answerIndex) => `
                            <div class="form-check">
                                <input type="radio" name="q-0" id="q-0-a-${answerIndex}" value="${answer.text}" />
                                <label for="q-0-a-${answerIndex}">${answer.text}</label>
                            </div>
                        `).join('')}
                    </form>
                </div>
                
                <!-- Question 2 -->
                <div class="question">
                    <h3>${questions[ramdomizeNumbers2].question}</h3>
                    <form id="question-1">
                        ${questions[ramdomizeNumbers2].answers.map((answer, answerIndex) => `
                            <div class="form-check">
                                <input type="radio" name="q-1" id="q-1-a-${answerIndex}" value="${answer.text}" />
                                <label for="q-1-a-${answerIndex}">${answer.text}</label>
                            </div>
                        `).join('')}
                    </form>
                </div>

                <!-- Question 3 -->
                <div class="question">
                    <h3>${questions[ramdomizeNumbers3].question}</h3>
                    <form id="question-2">
                        ${questions[ramdomizeNumbers3].answers.map((answer, answerIndex) => `
                            <div class="form-check">
                                <input type="radio" name="q-2" id="q-2-a-${answerIndex}" value="${answer.text}" />
                                <label for="q-2-a-${answerIndex}">${answer.text}</label>
                            </div>
                        `).join('')}
                    </form>
                </div>
                
                <!-- Button to calculate the score -->
                <button id="calculate-score">Calculate Score</button>
                
                <!-- Container to display the score -->
                <div id="score-container" style="display: none;">
                    <p>Your Score: <span id="score">0</span> / 3</p>
                    <button id="restart-game">Restart Game</button>
                </div>
            </div>
        </div>
    </div>
    `;

    
    const calculateScoreButton = document.getElementById('calculate-score');
    calculateScoreButton.addEventListener('click', calculateScore);
};

const calculateScore = () => {
    const scoreContainer = document.getElementById('score-container');
    const scoreElement = document.getElementById('score');
    const restartGameButton = document.getElementById('restart-game');
    const question0 = document.getElementById('question-0');
    const question1 = document.getElementById('question-1');
    const question2 = document.getElementById('question-2');
    const questionElements = [question0, question1, question2];
    let scoreValue = 0;

   
    questionElements.forEach((question, questionIndex) => {
     
        const correctAnswerInput = question.querySelector('input[value="true"]');
        const userAnswerInput = question.querySelector('input:checked');

        
        if (correctAnswerInput === userAnswerInput) {
            scoreValue++;
        }
    });

    scoreElement.innerHTML = scoreValue;
    scoreContainer.style.display = 'block';
    
    restartGameButton.addEventListener('click', () => {
        window.location.reload();
    });
};

export default GamePage;
