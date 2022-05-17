class GetMetricsInRange {
  async request(init, end) {
    const response = await fetch(`http://localhost:8080/metrics?init=${init}&end=${end}`)
    return await response.json();
  }
}

export default new GetMetricsInRange();
