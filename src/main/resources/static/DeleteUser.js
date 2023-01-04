const deleteForm = document.getElementById('deleteForm')
deleteForm.addEventListener('submit', e => {
    e.preventDefault()
    const formData = new FormData(deleteForm)

    fetch("/api/user/" + formData.get("id"), {
        method: "DELETE"
    })
        .then(() => getUsers());
    $("#ModalDelete").modal("hide"); // ?
    deleteForm.reset();
})

//Modal
const deleteModal = document.getElementById("ModalDelete")
deleteModal.addEventListener("show.bs.modal", e => {
    //
    const deleteButton = e.relatedTarget

    const deleteId = deleteButton.getAttribute('data-bs-userId')
    const deleteName = deleteButton.getAttribute('data-bs-userUsername')
    const deletePassword = deleteButton.getAttribute('data-bs-userPassword')

    const deleteModalId = deleteModal.querySelector('#userIdDelete')
    const deleteModalName = deleteModal.querySelector('#userUsernameDelete')
    const deleteModalPassword = deleteModal.querySelector('#userPasswordDelete')

    deleteModalId.value = deleteId
    deleteModalName.value = deleteName
    deleteModalPassword.value = deletePassword
})