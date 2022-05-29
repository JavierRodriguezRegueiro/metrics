import Timeline from "@mui/lab/Timeline";
import TimelineItem from "@mui/lab/TimelineItem";
import TimelineSeparator from "@mui/lab/TimelineSeparator";
import TimelineDot from "@mui/lab/TimelineDot";
import TimelineConnector from "@mui/lab/TimelineConnector";
import TimelineContent from "@mui/lab/TimelineContent";

const MetricsTimeLine = ({metrics}) => {
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

export default MetricsTimeLine;
