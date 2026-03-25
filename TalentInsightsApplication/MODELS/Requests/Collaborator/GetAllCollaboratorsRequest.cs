namespace TalentInsightsApplication.MODELS.Requests.Collaborator
{
    public class GetAllCollaboratorsRequest
    {
        public int? Limit { get; set; }
        public int? Offset { get; set; }

        public string? GitlabProfile { get; set; }

        public string? FullName { get; set; }

    }
}
