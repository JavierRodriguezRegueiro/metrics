import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import {Button, TextField} from "@mui/material";
import Timeline from '@mui/lab/Timeline';
import TimelineItem from '@mui/lab/TimelineItem';
import TimelineSeparator from '@mui/lab/TimelineSeparator';
import TimelineConnector from '@mui/lab/TimelineConnector';
import TimelineContent from '@mui/lab/TimelineContent';
import TimelineDot from '@mui/lab/TimelineDot';
import {useState} from "react";
import GetMetricsInRange from "../../api/GetMetricsInRange";
import './GetMetrics.css';


const GetMetrics = () => {
  const [initialDate, setInitialDate] = useState(null);
  const [endDate, setEndDate] = useState(null);
  const [metrics, setMetrics] = useState([]);

  const requestMetrics = async () => {
    const data =await GetMetricsInRange.request(initialDate.getTime(), endDate.getTime());
    setMetrics(data);
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

  const MetricsTimeLine = () => {
    return (
      <Timeline>
        {metrics.map(metric => {
          return (
            <TimelineItem key={metric.id}>
              <TimelineSeparator>
                <TimelineDot />
                <TimelineConnector />
              </TimelineSeparator>
              <TimelineContent>{metric.name}</TimelineContent>
            </TimelineItem>
          )
        })}
      </Timeline>
    );
  }

  return (
    <div className='getMetrics'>
      {inputs()}
      {metrics.length > 0 && <MetricsTimeLine metrics={metrics}/>}
    </div>
  );
}

export default GetMetrics;
