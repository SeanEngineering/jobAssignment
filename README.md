# jobAssignment

Endpoints
POST /jobs - Creates a job
PATCH /jobs/{id} - Updates job, endpoint should be used to assign temps to jobs
GET /jobs - Fetch all jobs
GET /jobs?assigned={true|false} - Filter by whether a job is assigned to a temp or not
GET /jobs/{id} - (id, name, tempId, startDate, endDate)
POST /temps - Create a temp
GET /temps - List all temps
GET /temps?jobId={jobId} - List temps that are available for a job based on the jobs date range
GET /temps/{id} - get temp by id (should also display jobs they’ve been assigned to)

Assumptions
Temps can only have one job at a time (can’t be doing 2 jobs on the same date)
Temps can have many jobs, and job can have 1 temp assigned
Should be able to assign existing temps to jobs via POST /jobs & PATCH /jobs/{id}
