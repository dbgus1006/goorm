const github = new Github();
const ui = new UI();
let execute;

const searchUser = document.querySelector("#search-user");

searchUser.addEventListener("keydown", e => {
    if (e.which === 32) e.preventDefault();
});

searchUser.addEventListener("keyup", e => {
    clearTimeout(execute);
    const userText = e.target.value;
    execute = setTimeout(extractInfo, 1000, userText.trim());
});

function extractInfo(userText) {
    if (userText !== "") {
        ui.showLoading();
        github.getuser(userText).then(data => {
            ui.hideLoading();
            if (data.profile.message === "Not Found") {
                ui.showAlert("User not found", "alert alert-danger");
            }
            else {
                ui.showProfile(data.profile);
                ui.showRepos(data.repos);
            }
        })
        .catch(() => {
            ui.hideLoading();
            ui.showAlert("User not found", "alert alert-danger");
        });
    }
    else {
        ui.clearProfile();
    }
}