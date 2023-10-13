/* eslint-disable */

const CreatPage = () => {
    const main = document.querySelector('main');
    main.innerHTML = `
    <h1>Create a query Page</h1>
    <form id="form" action="http://localhost:3000/queries" method="POST">
    <div class="mb-3">
        <label for="subject" class="form-label">Subject of your query</label>
        <input type="text" class="form-control" id="subject" name="subject" placeholder="Enter the subject of your query">
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Please provide the subject of your query regarding some new content</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    `;
    const form = document.querySelector('#form');
    form.addEventListener('submit', (event) => {
        event.preventDefault();
        const subject = document.querySelector('#subject').value;
        const data = {
            subject,
            status: 'requested',
        };
        fetch('http://localhost:3000/queries', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        }).then((response) => {
            if (response.status === 201) {
                window.location.hash = '#/queries';
            }
        });
    }
    );
};

export default CreatPage;