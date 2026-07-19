import React from 'react';

class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0, greeting: '' };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    this.setState({ greeting: 'Hello, the counter was incremented' });
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handlePress = (event) => {
    alert('I was clicked');
  };

  render() {
    return (
      <div>
        <h2>Counter: {this.state.count}</h2>
        <p>{this.state.greeting}</p>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <button onClick={() => this.sayWelcome('welcome')}>Say Welcome</button>
        <button onClick={this.handlePress}>Press Me</button>
      </div>
    );
  }
}

export default Counter;
