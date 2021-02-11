import template from "./dummy.html"

class DummyController {

    /** @ngInject */
    constructor($http) {
        this.$http = $http;

        this.contact = {
            id: "",
            fullName: "",
            firstName: "",
            lastName: "",
            proneNumber: "",
            cellProneNumber: "",
            address: ""
        };

        this.searchByParameter = "";
    }

    getAllContacts() {
        this.$http.get("/contacts").then((response) => {
            this.listOfContacts = response.data;
        });
    }

    findContact(searchByParameter) {
        this.$http.get("/contacts/findContact/" + searchByParameter).then((response) => {
            this.foundContact = response.data;
        });
    }

    addContact() {
        this.$http.post(`contacts/${this.contact.id ? 'update/' : 'add/'}`, this.contact).catch((response) => {
            this.errorMessage = response.data.message;
        });
    }

    deleteContact(contact) {
        this.$http.post("/contacts/delete/" + contact.fullName).then(() => {
        });
    }

    updateContact(index) {
        this.contact = this.listOfContacts[index];
    }
}

const component = {
    controller: DummyController,
    template,
    controllerAs: "ctrl"
}

export default component
