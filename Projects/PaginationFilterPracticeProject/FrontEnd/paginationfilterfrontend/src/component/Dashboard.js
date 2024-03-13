import React from 'react'
import { Card, CardBody, CardHeader, Col, Container, Row } from 'reactstrap'
import StudentTable from './StudentTable'

export default function Dashboard() {
  return (
    <div className='App mt-4 col-sm-12'>
        <Container>
            <Row>
                <Col>
                    <Card>
                        <CardHeader>
                            <h2>STUDENT TABLE</h2>
                        </CardHeader>
                        <CardBody>
                            <div>
                            <StudentTable/>
                            </div>
                            
                        </CardBody> 
                    </Card>
                </Col>
            </Row>
        </Container>
    </div>
  )
}
