class GetMetricsInRange {
  async request(init, end) {
    const response = await fetch(`http://localhost:8080/metrics?init=${init}&end=${end}`)
    const data = await  response.json();
    console.log(data)
  }
}

export default new GetMetricsInRange();
