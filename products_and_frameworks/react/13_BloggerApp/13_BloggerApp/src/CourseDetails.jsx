function CourseDetails({ seatsLeft }) {
  return (
    <div>
      <p>Course: "React for Beginners"</p>
      {seatsLeft > 0 && <p>Seats available: {seatsLeft}</p>}
      {seatsLeft === 0 && <p>This course is fully booked.</p>}
    </div>
  );
}

export default CourseDetails;
