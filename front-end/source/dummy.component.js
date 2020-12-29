import template from "./dummy.html"

class DummyController {


    /** @ngInject */
    constructor($http) {
        this.$http = $http;
        this.fullName = "";
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.cellPhoneNumber = "";
        this.address = "";

    }

    getAllContacts() {
        this.$http.get("/contacts").then((response) => {
            this.listOfContacts = response.data;
        });
    }

    addContact() {
        this.$http.post("/contacts/add", {
            fullName: this.fullName,
            firstName: this.firstName,
            lastName: this.lastName,
            phoneNumber: this.phoneNumber,
            cellPhoneNumber: this.phoneNumber,
            address: this.address
        }).then((response) => {
        });
    }
}


const component = {
    controller: DummyController,
    template,
    controllerAs: "ctrl"
}

export default component
