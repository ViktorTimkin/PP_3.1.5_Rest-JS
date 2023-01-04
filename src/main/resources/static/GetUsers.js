async function getUsers() {

    const response = await fetch("/api/user")
    if (response.ok) { // если HTTP-статус в диапазоне 200-299
        let json = await response.json() // Получаем тело ответа. Декодируем ответ в формате JSON.
            .then(data => table(data))
    } else {
        alert("Ошибка HTTP: " + response.status);
    }

    function table(data) { // Табла
        const placement = document.getElementById("userTablePlacement"); // ищет элемент по Id
        placement.innerHTML = "";
        data.forEach(({id, username, password, roles}) => {
            let userRoles = "";
            roles.forEach((role) => {
                userRoles = userRoles + role.name.split("_")[1]+" "
            })
            const element = document.createElement("tr")
            element.innerHTML = `
            <th scope="row">${id}</th>
            <td>${username}</td>
            <td>${password}</td>
            <td>${userRoles}</td>
            
            <!--Edit-->
            <td>
                <button type="button" class="btn btn-info text-white" data-bs-userId=${id}
                    data-bs-userUsername=${username} data-bs-userPassword=${password}
                    data-bs-toggle="modal"
                    data-bs-target="#ModalEdit">Edit</button>
            </td>
            
            <!--Delete-->
            <td>
                <button type="button" class="btn btn-danger" data-bs-userId=${id}
                    data-bs-userUsername=${username} data-bs-userPassword=${password}
                    data-bs-toggle="modal"
                    data-bs-target="#ModalDelete">Delete</button>
            </td>            
            `
            placement.append(element);
        })
    }
}