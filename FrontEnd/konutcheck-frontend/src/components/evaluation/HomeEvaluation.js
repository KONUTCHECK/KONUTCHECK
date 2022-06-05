import serialize from "form-serialize";
import React from "react";
import { Accordion, Button, Card, Form, ListGroup, ListGroupItem } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import EvaluationService from "../../api/EvaluationService";


class HomeEvaluation extends React.Component {

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newHomeEvaluation = serialize(e.target, { hash: true })

        this.saveHomeEvaluation(newHomeEvaluation);

    }

    saveHomeEvaluation(newHomeEvaluation) {
        EvaluationService.saveHomeEvaluation(newHomeEvaluation).then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        console.log(response);
    }

    handleError(error) {
        console.log("Değerlendirme yapılırken hata oluştu");
    }


    render() {


        return (
            <div className="row p-1">
                <Card className="my-card">
                    <Card.Body>
                        <Form onSubmit={this.handleFormSubmit}>
                        <ListGroup>
                            <ListGroup.Item>HomeCleaning: <input name="gradeOfHomeCleaning"/></ListGroup.Item>
                            <ListGroup.Item>gradeOfHomeReality : <input name="gradeOfHomeReality" /></ListGroup.Item>
                            <ListGroup.Item>gradeOfHomeModification: <input name="gradeOfHomeModification" /></ListGroup.Item>
                            <ListGroup.Item>gradeOfNetworkInfrastructure: <input name="gradeOfNetworkInfrastructure" /></ListGroup.Item>
                            <ListGroup.Item>gradeOfPhoneInfrastructure: <input name ="gradeOfPhoneInfrastructure"/></ListGroup.Item>
                            <ListGroup.Item>gradeOfHomeEnvironment: <input name ="gradeOfHomeEnvironment"  /></ListGroup.Item>
                            <ListGroup.Item>gradeOfHomeNeighborliness: <input name="gradeOfHomeNeighborliness" /></ListGroup.Item>
                            <ListGroup.Item>gradeOfHomeClosenessToSomewhere: <input name="gradeOfHomeClosenessToSomewhere" /></ListGroup.Item>
                        </ListGroup>

                        <input type="submit" className="btn btn-danger btn-block" value="Değerlendir" />

                        </Form>
                    </Card.Body>

             
                </Card>

            </div>
        );
    }
}
export default HomeEvaluation;
