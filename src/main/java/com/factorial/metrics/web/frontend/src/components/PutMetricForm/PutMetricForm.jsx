import {TextField, Button, Alert} from '@mui/material';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import {useState} from 'react';
import PutMetric from '../../api/PutMetric';
import './PutMetricForm.css'

const PutMetricForm = ({currentDate}) => {
  const initialMetricState = {
    date: currentDate,
    name: '',
    value: ''
  };
  const [metric, setMetric] = useState(initialMetricState);
  const [error, setError] = useState(false);

  const resetState = () => {
    setMetric(initialMetricState)
    setError(false);
  }

  const changeMetricAttribute = (attr, value) => {
    const newMetric = {...metric};
    newMetric[attr] = value
    setMetric(newMetric);
  }

  const changeDate = date => {
    changeMetricAttribute('date', date)
  }

  const changeName = e => {
    const {value} = e.target;
    changeMetricAttribute('name', value)
  }

  const changeValue = e => {
    const {value} = e.target;
    changeMetricAttribute('value', value)
  }

  const throwError = () => {
    throw new Error();
  }

  const submitAction = async () => {
    try {
      const request = await PutMetric.request(metric.date.getTime(), metric.name, metric.value)
      if(!request.ok) {
        throwError()
      }
      resetState();
    } catch (e) {
      setError(true);
    }
  }

  const generateButtonBar = () => {
    return (
      <div className='putMetricForm-buttonBar'>
        <Button variant="contained" onClick={submitAction}>Ok</Button>
        <Button onClick={resetState}>Cancel</Button>
      </div>
    )
  }

  return (
    <form className='putMetricForm' data-testid='putMetricForm'>
      {error && <Alert severity="error">Error sending metrics information</Alert>}
      <DateTimePicker
        renderInput={(props) => <TextField {...props}  />}
        label="Date and time"
        value={metric.date}
        onChange={(newValue) => {
          changeDate(newValue)
        }}
      />
      <TextField label='Name' value={metric.name} onChange={changeName} inputProps={{"data-testid":"putMetricForm-name"}} />
      <TextField label='Value' value={metric.value} onChange={changeValue} inputProps={{"data-testid":"putMetricForm-value"}} />
      {generateButtonBar()}
    </form>
  )
}

export default PutMetricForm;
