import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  return(
    <>
    <div className={styles.box}>
    <h3 className={cohort.current_status==="ongoing"?styles.ongoing:styles.completed}>{cohort.name}</h3>
     <dl>
      <dt>started_on</dt>
      <dd>
        {cohort.started_on}
      </dd>
      <dt>current_status</dt>
      <dd>
        {cohort.current_status}
      </dd>
      <dt>coach</dt>
      <dd>
        {cohort.coach}
      </dd>
      <dt>trainer</dt>
      <dd>
        {cohort.trainer}
      </dd>

  
     </dl>
     </div>
    </>
  );
}

export default CohortDetails;
