import serialize from "form-serialize";
import React from "react";
import { Accordion, Button, Card, Form, ListGroup, ListGroupItem } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import EvaluationService from "../../api/EvaluationService";


class TenantEvaluation extends React.Component {

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newTenantEvaluation = serialize(e.target, { hash: true })
        this.saveTenantEvaluation(newTenantEvaluation);

    }

    saveTenantEvaluation(newTenantEvaluation, tenantId) {
        EvaluationService.saveTenantEvaluation(newTenantEvaluation, tenantId).then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
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
                            <ListGroup.Item>gradeOfRentPayment: <input name="gradeOfRentPayment"/></ListGroup.Item>
                            <ListGroup.Item>gradeOfBillPayment : <input name="gradeOfBillPayment" /></ListGroup.Item>
                            <ListGroup.Item>gradeOfTenantSatisfaction: <input name="gradeOfTenantSatisfaction" /></ListGroup.Item>
                            <ListGroup.Item>gradeOfTenantNeighborliness: <input name="gradeOfTenantNeighborliness" /></ListGroup.Item>
                            <ListGroup.Item>gradeOfTenantHomeTreat: <input name="gradeOfTenantHomeTreat" /></ListGroup.Item>

                        </ListGroup>

                        <input type="submit" className="btn btn-danger btn-block" value="Değerlendir" />

                        </Form>
                    </Card.Body>

             
                </Card>

            </div>
        );
    }
}
export default TenantEvaluation;
