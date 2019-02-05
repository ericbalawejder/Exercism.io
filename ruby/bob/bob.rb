class Bob
  def self.hey(remark)
    case
    when remark == remark.upcase && remark != remark.downcase && remark.strip.end_with?('?')
      "Calm down, I know what I'm doing!"
    when remark.strip.end_with?('?')
      "Sure."
    when remark == remark.upcase && remark != remark.downcase
      "Whoa, chill out!"
    when remark.strip.empty?
      "Fine. Be that way!"
    else
      "Whatever."
    end
  end
end
