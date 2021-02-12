import angular from "angular"
import dummyComponent from "./dummy.component"
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.css';

angular.module("app", []).component("component", dummyComponent)