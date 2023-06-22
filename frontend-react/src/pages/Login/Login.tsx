import Position from "../../models/Position";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function Login() {
  

  function test(): void {
    const newPosition = new Position('asas', '', 0);
    console.log(newPosition.getPosition());
  }

  return (
    <>
      <header></header>
      <section>
        <h1>Login</h1>
        <button type="button" onClick={test}>
          Test
        </button>
      </section>
      <footer></footer>
    </>
  );
}
