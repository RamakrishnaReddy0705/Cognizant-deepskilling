import React from 'react';

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      password: '',
      errors: {},
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    this.setState({ [name]: value });
  };

  validate = () => {
    const errors = {};
    const { name, email, password } = this.state;

    if (name.trim().length < 5) {
      errors.name = 'Name should have at least 5 characters';
    }

    if (!email.includes('@') || !email.includes('.')) {
      errors.email = 'Email should contain @ and .';
    }

    if (password.length < 8) {
      errors.password = 'Password should have at least 8 characters';
    }

    return errors;
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const errors = this.validate();
    this.setState({ errors });

    if (Object.keys(errors).length === 0) {
      alert('Registration successful');
    }
  };

  render() {
    const { name, email, password, errors } = this.state;

    return (
      <div>
        <h2>Mail Register</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>
              Name
              <input type="text" name="name" value={name} onChange={this.handleChange} />
            </label>
            {errors.name && <p className="error">{errors.name}</p>}
          </div>
          <div>
            <label>
              Email
              <input type="text" name="email" value={email} onChange={this.handleChange} />
            </label>
            {errors.email && <p className="error">{errors.email}</p>}
          </div>
          <div>
            <label>
              Password
              <input type="password" name="password" value={password} onChange={this.handleChange} />
            </label>
            {errors.password && <p className="error">{errors.password}</p>}
          </div>
          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}

export default Register;
