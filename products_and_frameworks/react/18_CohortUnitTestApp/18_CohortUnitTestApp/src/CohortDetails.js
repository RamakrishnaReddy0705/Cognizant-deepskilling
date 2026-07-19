import React from 'react';

class CohortDetails extends React.Component {
  render() {
    const { cohort } = this.props;
    const titleColor = cohort.status === 'ongoing' ? 'green' : 'blue';

    return (
      <div className="box">
        <h3 style={{ color: titleColor }}>{cohort.code}</h3>
        <p>{cohort.name}</p>
        <p>Trainer: {cohort.trainer}</p>
        <p>Status: {cohort.status}</p>
      </div>
    );
  }
}

export default CohortDetails;
