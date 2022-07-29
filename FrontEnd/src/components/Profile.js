import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';
import NavigationBar from './NavBar';
import uimg from './user/uimg2.png'
function KitchenSinkExample() {
  const usera=localStorage.getItem("uname");
  return (
    <>
    <NavigationBar />
    <Card style={{ width: '20rem', marginLeft: '500px', marginTop: '150px', height: '550px'}}>
      <Card.Img variant="top" src={uimg} width='50px' height='250px'/>
      <Card.Body>
        <Card.Title>{usera}</Card.Title>
        <Card.Text>
          Flat 208 Raheja Residency, Koramangala 1st Block, Bengaluru, Karnataka, 500068
        </Card.Text>
      </Card.Body>
      <ListGroup className="list-group-flush">
        <ListGroup.Item>{usera}@gmail.com</ListGroup.Item>
        <ListGroup.Item>9867556431</ListGroup.Item>
      </ListGroup>
      
    </Card>
    </>
  );
}

export default KitchenSinkExample;
