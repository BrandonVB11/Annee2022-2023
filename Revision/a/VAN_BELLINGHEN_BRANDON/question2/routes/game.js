import questions from "../data/questions.json";
const router = express.Router();

router.get("/games/start"), (req, res) => {
    const level = req?.query?.level;
    const allQuestions = questions;

    if (!level) {
        const randomizeNumbers1 = Math.floor(Math.random() * 25);
        const randomizeNumbers2 = Math.floor(Math.random() * 25);
        const randomizeNumbers3 = Math.floor(Math.random() * 25);

        const game = {
            "questions": [
                allQuestions[randomizeNumbers1],
                allQuestions[randomizeNumbers2],
                allQuestions[randomizeNumbers3]
            ]
        }

        return res.json(game);
    } else if (level === "easy" || level === "medium" || level === "hard") {
        const filteredQuestions = allQuestions.filter(question => question.level === level);
        const randomizeNumbers1 = Math.floor(Math.random() * filteredQuestions.length);
        const randomizeNumbers2 = Math.floor(Math.random() * filteredQuestions.length);
        const randomizeNumbers3 = Math.floor(Math.random() * filteredQuestions.length);

        const game = {
            "questions": [
                filteredQuestions[randomizeNumbers1],
                filteredQuestions[randomizeNumbers2],
                filteredQuestions[randomizeNumbers3]
            ]
        }

        return res.json(game);
    } else {
        return res.sendStatus(400);
    }
}

router.post("/games", (req, res) => {
    const { username, score } = req.body;
    const date = new Date();

    if (score < 0 || score > 3) {
        return res.sendStatus(400);
    }

    const game = {
        username,
        score,
        date
    }

    const games = JSON.parse(fs.readFileSync("./data/games.json"));
    games.push(game);
    fs.writeFileSync("./data/games.json", JSON.stringify(games));

    return res.json(game);
});

module.exports = router;
