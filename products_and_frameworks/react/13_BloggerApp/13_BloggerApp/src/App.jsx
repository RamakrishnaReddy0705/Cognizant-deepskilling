import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const isBookAvailable = true;
  const isBlogPublished = false;
  const seatsLeft = 3;

  let statusMessage;
  if (seatsLeft > 5) {
    statusMessage = <p>Plenty of seats left.</p>;
  } else if (seatsLeft > 0) {
    statusMessage = <p>Hurry, only a few seats left!</p>;
  } else {
    statusMessage = <p>Registrations closed.</p>;
  }

  return (
    <div>
      <h1>Blogger App</h1>

      <h2>If / Else Conditional Rendering</h2>
      <BookDetails available={isBookAvailable} />

      <h2>Ternary Operator Conditional Rendering</h2>
      <BlogDetails published={isBlogPublished} />

      <h2>Logical && Conditional Rendering</h2>
      <CourseDetails seatsLeft={seatsLeft} />

      <h2>Element Variable Conditional Rendering</h2>
      {statusMessage}
    </div>
  );
}

export default App;
