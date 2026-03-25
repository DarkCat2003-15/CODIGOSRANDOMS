using System.ComponentModel.DataAnnotations;
using TalentInsightsShared.Constants;

namespace TalentInsightsApplication.MODELS.Requests.Collaborator
{
    public class UpdateCollaboratorRequest
    {
        [Required(ErrorMessage = ValidationConstants.Required)]  //Sirve para validar el dato si es obligatorio y el tipo
        [MaxLength(150, ErrorMessage = ValidationConstants.MaxLength)]
        [MinLength(10, ErrorMessage = ValidationConstants.MinLength)]
        public string FullName { get; set; }
        [MaxLength(255, ErrorMessage = ValidationConstants.MaxLength)]
        [MinLength(10, ErrorMessage = ValidationConstants.MinLength)]
        public string GitlabProfile { get; set; }
        [Required(ErrorMessage = ValidationConstants.Required)]
        [MaxLength(100, ErrorMessage = ValidationConstants.MaxLength)]
        [MinLength(5, ErrorMessage = ValidationConstants.MinLength)]
        public string position { get; set; }


    }
}
