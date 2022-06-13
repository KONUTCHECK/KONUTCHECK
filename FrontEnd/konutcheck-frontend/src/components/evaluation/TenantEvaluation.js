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
                        <p> <b>Aşağıdaki soruları kiracınızın evinizde yaşadığı süre zarfında size ve eve karşı tutumlarını dikkate alarak 1 (en düşük) ile 5 (en yüksek) olacak şekilde puanlayınız. </b></p>
                            <ListGroup.Item>Kiracınız kira ücretini aksatmadan ve zamanında öder miydi? <input type="number" min="0" max="5" name="gradeOfRentPayment"/></ListGroup.Item>
                            <ListGroup.Item>Kiracınız, kiracısı olduğu evin faturalarını aksatmadan ve zamanında öder miydi? <input type="number" min="0" max="5" name="gradeOfBillPayment" /></ListGroup.Item>
                            <ListGroup.Item>Kiracınızın size karşı hal ve tutumları nasıldı? <input type="number" min="0" max="5" name="gradeOfTenantSatisfaction" /></ListGroup.Item>
                            <ListGroup.Item>Kiracınızın komşuluk ilişkileri nasıldı? (Komşularından herhangi bir şikayet vb. duyumlar alma gibi.) <input type="number" min="0" max="5" name="gradeOfTenantNeighborliness" /></ListGroup.Item>
                            <ListGroup.Item>Kiracınız, evinizde kiracıyken eve herhangi bir zarar verdi mi? (duvarlara çivi çakma, evde izinsiz tadilat yapma vb.) <input type="number" min="0" max="5" name="gradeOfTenantHomeTreat" /></ListGroup.Item>

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
