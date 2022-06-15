import serialize from "form-serialize";
import React from "react";
import { Accordion, Button, Card, Form, ListGroup, ListGroupItem } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import EvaluationService from "../../api/EvaluationService";
import ToastMessage from "../general/toastMessage";



class TenantEvaluation extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            toast: false,
            type: 'success',
            message: 'Kiracı başarıyla değerlendirildi :)'
        }
    }

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newTenantEvaluation = serialize(e.target, { hash: true })
        const tenantId = window.location.pathname.split('/')[2];
        this.saveTenantEvaluation(newTenantEvaluation, tenantId);

    }

    saveTenantEvaluation(newTenantEvaluation, tenantId) {
        EvaluationService.saveTenantEvaluation(newTenantEvaluation, tenantId).then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({
            toast: true,
            type: 'success',
            message: 'Kiracı başarıyla değerlendirildi :)'
        })
        setTimeout(() => {
            this.setState({ toast: false })
        }, 100);
        console.log(response);
    }

    handleError(error) {
        this.setState({
            toast: true,
            type: 'error',
            message: "Değerlendirme yapılırken hata oluştu, lütfen hiçbir alanı boş bırakmadan 1-5 arasında puanlayınız :("
        })
        setTimeout(() => {
            this.setState({ toast: false })
        }, 100);
    }


    render() {


        return (
            <div className="row p-1">
                <Card className="my-card">
                    <Card.Body>
                        <Form onSubmit={this.handleFormSubmit}>
                            <ListGroup>
                                <p> <b>Aşağıdaki soruları kiracınızın evinizde yaşadığı süre zarfında size ve eve karşı tutumlarını dikkate alarak 1 (en düşük) ile 5 (en yüksek) olacak şekilde puanlayınız. </b></p>
                                <ListGroup.Item>Kiracınız kira ücretini aksatmadan ve zamanında öder miydi? <input type="number" min="0" max="5" name="gradeOfRentPayment" /></ListGroup.Item>
                                <ListGroup.Item>Kiracınız, kiracısı olduğu evin faturalarını aksatmadan ve zamanında öder miydi? <input type="number" min="0" max="5" name="gradeOfBillPayment" /></ListGroup.Item>
                                <ListGroup.Item>Kiracınızın size karşı hal ve tutumları nasıldı? <input type="number" min="0" max="5" name="gradeOfTenantSatisfaction" /></ListGroup.Item>
                                <ListGroup.Item>Kiracınızın komşuluk ilişkileri nasıldı? (Komşularından herhangi bir şikayet vb. duyumlar alma gibi.) <input type="number" min="0" max="5" name="gradeOfTenantNeighborliness" /></ListGroup.Item>
                                <ListGroup.Item>Kiracınız, evinizde kiracıyken eve herhangi bir zarar verdi mi? (duvarlara çivi çakma, evde izinsiz tadilat yapma vb.) <input type="number" min="0" max="5" name="gradeOfTenantHomeTreat" /></ListGroup.Item>

                            </ListGroup>

                            <input type="submit" className="btn btn-danger btn-block" value="Değerlendir" />

                        </Form>
                    </Card.Body>


                </Card>

                {this.state.toast &&
                    <ToastMessage type={this.state.type} message={this.state.message}></ToastMessage>
                }
            </div>
        );
    }
}
export default TenantEvaluation;
