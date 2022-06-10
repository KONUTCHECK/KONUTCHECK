import serialize from "form-serialize";
import React from "react";
import { Accordion, Button, Card, Form, ListGroup, ListGroupItem } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import EvaluationService from "../../api/EvaluationService";


class LandlordEvaluation extends React.Component {

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newLandlordEvaluation = serialize(e.target, { hash: true })

        this.saveLandlordEvaluation(newLandlordEvaluation);

    }

    saveLandlordEvaluation(newLandlordEvaluation) {
        EvaluationService.saveLandlordEvaluation(newLandlordEvaluation).then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
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
                                <ListGroup.Item>gradeOfLandlordSatisfaction <input name="gradeOfLandlordSatisfaction" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfLandlordTreatment : <input name="gradeOfLandlordTreatment" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfLandlordAccessibility: <input name="gradeOfLandlordAccessibility" /></ListGroup.Item>
                                <ListGroup.Item>gradeOfLandlordUnderstanding: <input name="gradeOfLandlordUnderstanding" /></ListGroup.Item>
                            </ListGroup>

                            <input type="submit" className="btn" value="Değerlendir" style={{ marginTop: '10px' }} />

                        </Form>
                    </Card.Body>


                </Card>

            </div>
        );
    }
}
export default LandlordEvaluation;
