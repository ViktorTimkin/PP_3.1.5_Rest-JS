const editForm = document.getElementById("editForm");
editForm.addEventListener('submit', e => {

    e.preventDefault();
    const formData = new FormData(editForm);
    const object = {roles: []};

    formData.forEach((value, key) => {
        if (key === "rolesId") {
            const roleId = value.split(" ")[0];
            const roleName = value.split(" ")[1];
            const role = {
                id: roleId,
                name: "ROLE_" + roleName
            };
            object.roles.push(role);
        } else {
            object[key] = value;
        }
    });
    fetch("api/user/" + formData.get("id"), {
        method: "PUT",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(() => getUsers());
    $("#ModalEdit").modal("hide");
    editForm.reset();
})


//Modal
const editModal = document.getElementById('ModalEdit')
editModal.addEventListener('show.bs.modal', event => {

    const editButton = event.relatedTarget

    const editUserId = editButton.getAttribute('data-bs-userId')
    const editUserUsername = editButton.getAttribute('data-bs-userUsername')
    const editUserPassword = editButton.getAttribute('data-bs-userPassword')

    const editModalUserId = editModal.querySelector('#userId')
    const editModalUserUsername = editModal.querySelector('#userUsername')
    const editModalUserPassword = editModal.querySelector('#userPassword')

    editModalUserId.value = editUserId
    editModalUserUsername.value = editUserUsername
    editModalUserPassword.value = editUserPassword

})