#!/bin/bash

# Check if we are inside a git repo
if ! git rev-parse --git-dir > /dev/null 2>&1; then
    echo "Not a git repository."
    exit 1
fi

# Loop over all tracked and untracked files
for file in $(git ls-files --others --exclude-standard) $(git ls-files); do
    # Skip directories
    if [ -d "$file" ]; then
        continue
    fi

    echo "Processing $file..."

    # Add the file
    git add "$file"

    # Commit with file-specific message
    git commit -m "Update $file"

    # Push to the current branch
    git push
done

echo "All files committed and pushed individually."
