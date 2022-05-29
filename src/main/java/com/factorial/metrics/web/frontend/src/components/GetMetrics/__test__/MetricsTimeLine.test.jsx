import {render} from '@testing-library/react';
import MetricsTimeLine from "../MetricsTimeLine";

describe('<MetricsTimeLine />', () => {
  it('should be render without crash', () => {
    const {container} = render(<MetricsTimeLine metrics={[{name: 'test', id: 'id'}]}/>)
    expect(container).toBeInTheDocument();
  })
});
