/* eslint-disable */

const ManagePage = () => {
    const main = document.querySelector('main');
    main.innerHTML = `
    <h1>Manage queries Page</h1>
    <div id="queries"></div>
    `;
    const queries = document.querySelector('#queries');
    fetch('http://localhost:3000/queries')
        .then((response) => response.json())
        .then((data) => {
            const queriesList = data.map((query) => {
                return `
                <div class="card">
                <div class="card-body">
                <h5 class="card-title">${query.subject}</h5>
                <p class="card-text">${query.status}</p>
                <select id="status" name="status">
                <option value="requested">Requested</option>
                <option value="accepted">Accepted</option>
                <option value="refused">Refused</option>
                <option value="done">Done</option>
                </select>
                <button type="button" class="btn btn-primary" id="update" data-id="${query.id}">Update</button>
                </div>
                </div>
                `;
            });
            queries.innerHTML = queriesList.join('');
            const updateButtons = document.querySelectorAll('#update');
            updateButtons.forEach((button) => {
                button.addEventListener('click', (event) => {
                    const id = event.target.dataset.id;
                    const status = event.target.parentElement.querySelector('#status').value;
                    const data = {
                        status,
                    };
                    fetch(`http://localhost:3000/queries/${id}`, {
                        method: 'PATCH',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify(data),
                    }).then((response) => {
                        if (response.status === 200) {
                            window.location.hash = '#/queries';
                        }
                    });
                });
            });
        });
};

export default ManagePage;