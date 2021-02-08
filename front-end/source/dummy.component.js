import template from "./dummy.html"

class DummyController {


    /** @ngInject */
    constructor($http) {
        this.$http = $http;

        this.contact = {
            fullName: "",
            firstName: "",
            lastName: "",
            proneNumber: "",
            cellProneNumber: "",
            address: ""
        };
    }

    getAllContacts() {
        this.$http.get("/contacts").then((response) => {
            this.listOfContacts = response.data;
        });
    }

    findContact() {
        this.$http.post("/contacts/findContact", this.contact).then((response) => {
            this.oneContact = response.data;
        });
    }

    addContact() {
        this.$http.post("/contacts/add", this.contact).catch((response) => {
            this.errorMessage = response.data.message;
        });
    }
}


const component = {
    controller: DummyController,
    template,
    controllerAs: "ctrl"
}

export default component
