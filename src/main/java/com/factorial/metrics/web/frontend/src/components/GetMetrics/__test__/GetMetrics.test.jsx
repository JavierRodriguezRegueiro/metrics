import {render} from '@testing-library/react';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import GetMetrics from '../GetMetrics';

const EncapsulateGetMetrics = () => {
  return (
    <LocalizationProvider dateAdapter={AdapterDateFns}>
      <GetMetrics />
    </LocalizationProvider>
  )
}

describe('<GetMetrics />', () => {
  it('should render without crash', () => {
    const {container} = render(<EncapsulateGetMetrics />);
    expect(container).toBeInTheDocument();
  })

  it('button should be disabled if there is no initial date or end date', () => {
    const {getByRole} = render(<EncapsulateGetMetrics />);
    expect(getByRole('button')).toBeDisabled();
  })
})
