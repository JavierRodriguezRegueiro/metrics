import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import {Alert, Button, TextField, MenuItem} from "@mui/material";
import {useState} from 'react';
import GetMetricsInRange from '../../api/GetMetricsInRange';
import MetricsTimeLine from './MetricsTimeLine';
import './GetMetrics.css';

const orderValues = [
    {
      value: 'days',
      label: 'Days',
      sections: undefined
    },
  {
    value: 'hours',
    label: 'Hours',
    sections: 24
  },
  {
    value: 'minutes',
    label: 'Minutes',
    sections: 60
  }
];

const GetMetrics = () => {
  const [initialDate, setInitialDate] = useState(null);
  const [endDate, setEndDate] = useState(null);
  const [metrics, setMetrics] = useState([]);
  const [error, setError] = useState(false);
  const [order, setOrder] =  useState(orderValues[0]);

  const requestMetrics = async () => {
    try {
      const data = await GetMetricsInRange.request(initialDate.getTime(), endDate.getTime());
      setMetrics(data);
      setError(false);
    } catch (e) {
      setError(true);
    }
  }

  const hasDatesToSend = () => {
    return initialDate && endDate;
  }

  const changeOrderBy = (event) => {
    setOrder(orderValues.find(order => order.value === event.target.value));
  }

  const clearMetrics = () => {
    setMetrics([]);
  }

  const inputs = () => {
    return (
      <div className='getMetrics-inputs'>
        <DateTimePicker
          renderInput={(props) => <TextField {...props}  />}
          label="Initial date"
          value={initialDate}
          onChange={(newValue) => {
            clearMetrics()
            setInitialDate(newValue)
          }}
        />
        <DateTimePicker
          data-testid='my-test-id'
          renderInput={(props) => <TextField {...props}  />}
          label="End date"
          value={endDate}
          onChange={(newValue) => {
            clearMetrics()
            setEndDate(newValue)
          }}
        />
        <TextField
          select
          value={order.value}
          label="Order by"
          onChange={changeOrderBy}
        >
          {orderValues.map(order => {
            return <MenuItem key={order.value} value={order.value}>{order.label}</MenuItem>
          })}
        </TextField>
        <Button variant="contained" onClick={async () => await requestMetrics()} disabled={!hasDatesToSend()}>Send</Button>
      </div>
    )
  }


  return (
    <div className='getMetrics'>
      {inputs()}
      {error && <Alert severity="error">Error sending metric information</Alert>}
      {metrics.length > 0 && <MetricsTimeLine metrics={metrics} order={order} initialDate={initialDate} endDate={endDate}/>}
    </div>
  );
}

export default GetMetrics;
