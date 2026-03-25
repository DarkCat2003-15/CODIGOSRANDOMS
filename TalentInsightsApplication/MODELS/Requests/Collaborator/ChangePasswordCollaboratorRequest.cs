using System.ComponentModel.DataAnnotations;
using TalentInsightsShared.Constants;

namespace TalentInsightsApplication.MODELS.Requests.Collaborator
{
    public class ChangePasswordCollaboratorRequest
    {
        [Required(ErrorMessage = ValidationConstants.Required)]
        public string? CurrentPassword { get; set; }
        [Required(ErrorMessage = ValidationConstants.Required)]
        public string? NewPassword { get; set; }
        [Required(ErrorMessage = ValidationConstants.Required)] public string? ConfirmPassword { get; set; }




    }
}
