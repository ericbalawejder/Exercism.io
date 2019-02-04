class Acronym
  def self.abbreviate(sentence)
    sentence.gsub(/\B.|\P{L}/, '').upcase
  end
end
