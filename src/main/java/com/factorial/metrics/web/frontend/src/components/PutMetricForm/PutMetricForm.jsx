import {TextField, Button} from '@mui/material';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import {useState} from "react";
import PutMetric from '../../api/PutMetric';
import './PutMetricForm.css'

const PutMetricForm = ({currentDate}) => {
  const initialMetricState = {
    date: currentDate,
    name: '',
    value: ''
  };
  const [metric, setMetric] = useState(initialMetricState);

  const resetMetricState = () => {
    setMetric(initialMetricState)
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

  const submitAction = async () => {
    await PutMetric.request(metric.date.getTime(), metric.name, metric.value)
    await resetMetricState();
  }

  const generateButtonBar = () => {
    return (
      <div className='putMetricForm-buttonBar'>
        <Button variant="contained" onClick={submitAction}>Ok</Button>
        <Button onClick={resetMetricState}>Cancel</Button>
      </div>
    )
  }

  return (
    <form className='putMetricForm' data-testid='putMetricForm'>
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
