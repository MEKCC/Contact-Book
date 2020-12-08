import angular from "angular"
import template from "./dummy.html"

class DummyController {

    /** @ngInject */
    constructor() {
        this.name = "Sam"
    }
}


//     /** @ngInject */
//     constructor($http) {
//         this.$http = $http;
//         this.$http.get("/contacts").then(function (response) {
//             console.log(response);
//         });
//     }
// }

//     /** @ngInject */
//     constructor($http) {
//         var $ = require ('gulp-load-plugins') ();
//         $ .uglify ({mangle: false, compress: true, output: {beautify: false}})
//         this.$http = $http;
//         this.$http.get("contacts").then(function (response) {
//             console.log(response);
//         });
//     }
// }


const component = {
    controller: DummyController,
    template
}

export default angular.module("app.dummy", [])
    .component("dummyComponent", component)
    .name