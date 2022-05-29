import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import {Alert, Button, TextField} from "@mui/material";
import {useState} from "react";
import GetMetricsInRange from "../../api/GetMetricsInRange";
import MetricsTimeLine from "./MetricsTimeLine";
import './GetMetrics.css';


const GetMetrics = () => {
  const [initialDate, setInitialDate] = useState(null);
  const [endDate, setEndDate] = useState(null);
  const [metrics, setMetrics] = useState([]);
  const [error, setError] = useState(false);

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

  const inputs = () => {
    return (
      <div className='getMetrics-inputs'>
        <DateTimePicker
          renderInput={(props) => <TextField {...props}  />}
          label="Initial date"
          value={initialDate}
          onChange={(newValue) => {
            setInitialDate(newValue)
          }}
        />
        <DateTimePicker
          data-testid='my-test-id'
          renderInput={(props) => <TextField {...props}  />}
          label="End date"
          value={endDate}
          onChange={(newValue) => {
            setEndDate(newValue)
          }}
        />
        <Button variant="contained" onClick={async () => await requestMetrics()} disabled={!hasDatesToSend()}>Send</Button>
      </div>
    )
  }


  return (
    <div className='getMetrics'>
      {inputs()}
      {error && <Alert severity="error">Error sending metric information</Alert>}
      {metrics.length > 0 && <MetricsTimeLine metrics={metrics}/>}
    </div>
  );
}

export default GetMetrics;
