import React from 'react';

class ComplaintRegister extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeName: '',
      complaint: '',
    };
  }

  handleNameChange = (event) => {
    this.setState({ employeeName: event.target.value });
  };

  handleComplaintChange = (event) => {
    this.setState({ complaint: event.target.value });
  };

  generateReferenceNumber = () => {
    return 'REF' + Math.floor(100000 + Math.random() * 900000);
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const refNumber = this.generateReferenceNumber();
    alert(`Complaint submitted successfully. Your reference number is ${refNumber}`);
    this.setState({ employeeName: '', complaint: '' });
  };

  render() {
    return (
      <div>
        <h2>Raise a Complaint</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>
              Employee Name
              <input
                type="text"
                value={this.state.employeeName}
                onChange={this.handleNameChange}
                required
              />
            </label>
          </div>
          <div>
            <label>
              Complaint
              <textarea
                value={this.state.complaint}
                onChange={this.handleComplaintChange}
                required
              />
            </label>
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
