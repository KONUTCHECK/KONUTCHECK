import serialize from "form-serialize";
import React from "react";
import { Accordion, Button, Card, Form, ListGroup, ListGroupItem } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import EvaluationService from "../../api/EvaluationService";
import ToastMessage from "../general/toastMessage";



class HomeEvaluation extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            toast: false,
            type: 'success',
            message: 'Ev başarıyla değerlendirildi :)'
        }
    }

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newHomeEvaluation = serialize(e.target, { hash: true })
        this.saveHomeEvaluation(newHomeEvaluation);

    }

    saveHomeEvaluation(newHomeEvaluation) {
        EvaluationService.saveHomeEvaluation(newHomeEvaluation).then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({
            toast: true,
            type: 'success',
            message: 'Ev başarıyla değerlendirildi :)'
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
                                <p> <b>Aşağıdaki soruları kiracı olduğunuz süre boyunca oturduğunuz evi dikkate alarak 1 (en düşük) ile 5 (en yüksek) olacak şekilde puanlayınız. </b></p>
                                <ListGroup.Item>Ev temiz miydi? <input type="number" min="0" max="5" name="gradeOfHomeCleaning" /></ListGroup.Item>
                                <ListGroup.Item>Ev, ev sahibinizin ya da emlakçınızın size anlattığı gibi miydi?  <input type="number" min="0" max="5" name="gradeOfHomeReality" /></ListGroup.Item>
                                <ListGroup.Item>Evin tamirata ihtiyacı var mıydı?  <input type="number" min="0" max="5" name="gradeOfHomeModification" /></ListGroup.Item>
                                <ListGroup.Item>Evin internet altyapısı var mıydı, varsa nasıldı? <input type="number" min="0" max="5" name="gradeOfNetworkInfrastructure" /></ListGroup.Item>
                                <ListGroup.Item>Evin telefon altyapısı var mıydı, şebeke sorunsuz çalışıyor muydu? <input type="number" min="0" max="5" name="gradeOfPhoneInfrastructure" /></ListGroup.Item>
                                <ListGroup.Item>Evin çevresi nasıldı? Orada yaşamaktan memnun muydunuz? <input type="number" min="0" max="5" name="gradeOfHomeEnvironment" /></ListGroup.Item>
                                <ListGroup.Item>Evinizin bulunduğu binada, mahallede ya da sitede komşuluk ilişkileri nasıldı? <input type="number" min="0" max="5" name="gradeOfHomeNeighborliness" /></ListGroup.Item>
                                <ListGroup.Item>Evin muhiti nasıldı? Gerekli yerlere yakın mıydı? (hastane, okul, semt pazarı vb.) <input type="number" min="0" max="5" name="gradeOfHomeClosenessToSomewhere" /></ListGroup.Item>
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
export default HomeEvaluation;
