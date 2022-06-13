import serialize from "form-serialize";
import React from "react";
import { Accordion, Button, Card, Form, ListGroup, ListGroupItem } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import EvaluationService from "../../api/EvaluationService";
import ToastMessage from "../general/toastMessage";



class LandlordEvaluation extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            toast: false,
            type: 'success',
            message: 'Ev sahibi başarıyla değerlendirildi :)'
        }
    }

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newLandlordEvaluation = serialize(e.target, { hash: true })

        this.saveLandlordEvaluation(newLandlordEvaluation);

    }

    saveLandlordEvaluation(newLandlordEvaluation, landlordId) {
        EvaluationService.saveLandlordEvaluation(newLandlordEvaluation, landlordId).then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({
            toast: true,
            type: 'success',
            message: 'Ev sahibi başarıyla değerlendirildi :)'
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
                            <p> <b>Aşağıdaki soruları kiracı olduğunuz süre boyunca ev sahibinizin size karşı tutumlarını dikkate alarak 1 (en düşük) ile 5 (en yüksek) olacak şekilde puanlayınız. </b></p>
                                <ListGroup.Item>Ev sahibiniz size karşı ilgili miydi? Herhangi bir sorunda rahatlıkla onu arayabilir miydiniz? <input type="number" min="0" max="5" name="gradeOfLandlordSatisfaction" /></ListGroup.Item>
                                <ListGroup.Item>Ev sahibinizen size karşı hal ve tutumları nasıldı?  <input type="number" min="0" max="5" name="gradeOfLandlordTreatment" /></ListGroup.Item>
                                <ListGroup.Item>Herhangi acil bir durumda ev sahibinize hemen ulaşabilir miydiniz?  <input type="number" min="0" max="5" name="gradeOfLandlordAccessibility" /></ListGroup.Item>
                                <ListGroup.Item>Karşılaştığınız herhangi bir zor durumda ev sahibiniz anlayışlı mıydı? (Kirayı geç ödeme vb.) <input type="number" min="0" max="5" name="gradeOfLandlordUnderstanding" /></ListGroup.Item>
                            </ListGroup>

                            <input type="submit" className="btn" value="Değerlendir" style={{ marginTop: '10px' }} />

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
export default LandlordEvaluation;
