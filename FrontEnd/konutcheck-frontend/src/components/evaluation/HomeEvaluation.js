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
                                <ListGroup.Item>HomeCleaning: <input type="number" name="gradeOfHomeCleaning" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfHomeReality : <input type="number" name="gradeOfHomeReality" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfHomeModification: <input type="number" name="gradeOfHomeModification" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfNetworkInfrastructure: <input type="number" name="gradeOfNetworkInfrastructure" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfPhoneInfrastructure: <input type="number" name="gradeOfPhoneInfrastructure" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfHomeEnvironment: <input type="number" name="gradeOfHomeEnvironment" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfHomeNeighborliness: <input type="number" name="gradeOfHomeNeighborliness" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfHomeClosenessToSomewhere: <input type="number" name="gradeOfHomeClosenessToSomewhere" /></ListGroup.Item>
                            </ListGroup>

                            <input type="submit" className="btn" value="Değerlendir" style={{ marginTop: '10px' }} />

                        </Form>
                    </Card.Body>


                </Card>

            </div>
        );
    }
}
export default HomeEvaluation;
