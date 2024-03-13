namespace Bloggie.Web.Models.Domain
{
    public class Tag
    {
        public Guid Id { get; set; }
        public string Name { get; set; }
        public string DisplayName { get; set; }

        //one tag can have multiple blog and one blog can have multiple tags, so it is many to many relationship
        public ICollection<BlogPost> BlogPosts { get; set; }
    }
}
