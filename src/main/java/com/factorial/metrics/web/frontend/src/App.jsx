import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import PutMetricForm from './components/PutMetricForm/PutMetricForm';
import GetMetrics from './components/GetMetrics/GetMetrics';
import './App.css';

const App = () => {
  return (
    <LocalizationProvider dateAdapter={AdapterDateFns}>
      <div className="app" data-testid="app">
        <PutMetricForm currentDate={new Date()}/>
        <GetMetrics />
      </div>
    </LocalizationProvider>
  );
}

export default App;
