import template from "./dummy.html"

class DummyController {


    /** @ngInject */
    constructor($http) {
        this.$http = $http;

    }

    load() {
        this.$http.get("/contacts").then((response) => {
            this.name = JSON.stringify(response.data);
        });
    }
}


const component = {
    controller: DummyController,
    template,
    controllerAs: "ctrl"
}

export default component
