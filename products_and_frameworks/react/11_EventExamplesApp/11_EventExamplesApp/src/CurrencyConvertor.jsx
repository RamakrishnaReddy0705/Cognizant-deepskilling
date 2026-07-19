import React from 'react';

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = { rupees: '', euros: null };
    this.rate = 0.011;
  }

  handleChange = (event) => {
    this.setState({ rupees: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const converted = Number(this.state.rupees) * this.rate;
    this.setState({ euros: converted.toFixed(2) });
  };

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Indian Rupees:
            <input type="number" value={this.state.rupees} onChange={this.handleChange} />
          </label>
          <button type="submit">Convert</button>
        </form>
        {this.state.euros !== null && <p>Euros: {this.state.euros}</p>}
      </div>
    );
  }
}

export default CurrencyConvertor;
